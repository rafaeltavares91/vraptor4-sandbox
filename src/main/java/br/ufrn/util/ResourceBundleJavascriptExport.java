package br.ufrn.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.caelum.vraptor.http.InvalidParameterException;

/**
 * This component exports all supported locales of application. When the
 * application starts the .properties files will be exported to javascript files
 * with content in jQuery plugin format. <br>
 * To configure this component, will be necessary add the 'locales' parameter in
 * the web.xml, passing all application locales splited by commas. E.g:
 * pt,pt_BR,en,es <br>
 * All javascript files will be deployed to WebContent/js/i18n/, the origin of
 * .properties follow de Java specification for resources files,
 * resources/*.properties. <br>
 * The sintax of jQuery plugin its the same of fmt:message tag, but for jQuery: <br>
 * <code>alert ( $.msg( "you.key.of.propertie.file" ) );</code> <br>
 * When the plugins not found your key, the output will be between '?? XYZ ??',
 * the same of fmt:message tag. <br>
 * To import the Javascript file use this: <br>
 * <code>
 * &lt;script type="text/javascript" src="&lt;c:url value='/js/i18n/messages_${YOUR_LOCALE}.js'/&gt;"&gt;&lt;/script&gt;
 * </code>
 *
 * @author Carlos A. Junior (CIH - Centro Internacional de Hidroinformática -
 *         carlosjrcabello@gmail.com)
 *
 * @see ProtectionDomain
 *
 * @see CodeSource
 */
public class ResourceBundleJavascriptExport {

    private static final Locale DEFAULT_LOCALE = new Locale("pt", "br");
    private static final Logger logger = LoggerFactory.getLogger(ResourceBundleJavascriptExport.class);

    @Inject
    private ServletContext context;

    /** CDI */
    public ResourceBundleJavascriptExport() {
        this(null);
    }

    @Inject
    public ResourceBundleJavascriptExport(ServletContext context) {
        this.context = context;
    }

    public void aoIniciarAplicacao(@Observes VRaptorInitialized event) {
        initI18nJavascriptFilesDeploy();
    }

    public void initI18nJavascriptFilesDeploy() {
        logger.info("Generating the Javascript files for i18n.");
        try {
            List<Locale> locales = this.getApplicationLocales();

            for (Locale locale : locales) {
                ResourceBundle bundle = getResourceBundle(locale);
                this.deployI18nJavascriptFile(bundle);
            }
        } catch (Exception e) {
            logger.error("Could not deploy the Javascript files " + e);
        }
    }

    /**
     * Acessa o arquivo de mesangem relativo ao locale.
     *
     * @param locale
     * @return
     */
    private ResourceBundle getResourceBundle(Locale locale) {
        ResourceBundle bundle;

        if (locale.equals(DEFAULT_LOCALE)) {
            bundle = ResourceBundle.getBundle("messages", Locale.forLanguageTag(""));
        } else {
            bundle = ResourceBundle.getBundle("messages", locale);
        }

        return bundle;
    }

    /**
     * Returns an List of Locale objects based in the 'locales' parameter of
     * web.xml. All locales specified should be separated by commas.<br>
     * <br>
     *
     * <code>E.g: pt_BR,en,es</code>
     *
     * @return List
     *
     * @throws InvalidParameterException
     *             - when 'locales' parameter is null or empty.
     */
    public List<Locale> getApplicationLocales() {
        String s = this.context.getInitParameter("locales");

        String[] languages = s != null ? s.split(",") : null;

        if (languages == null || languages.length == 0) {
            throw new InvalidParameterException("Could not find any languages in web.xml 'locales' parameter.");
        }

        List<Locale> locales = new ArrayList<Locale>();

        for (String lang : languages) {
            String langAndContry[] = lang.split("_");

            if (langAndContry.length == 2) {
                locales.add(new Locale(langAndContry[0].trim(), langAndContry[1].trim().toUpperCase()));
            } else {
                locales.add(new Locale(langAndContry[0].trim()));
            }
        }

        return locales;
    }

    /**
     * Deploy an new Javascript file based in the content of ResourceBundle
     * object. The target folder is WEB-INF/js/i18n/. All files using the
     * current charset of 'br.com.caelum.vraptor.encoding' parameter.
     *
     * @param bundle
     *            properties
     *
     * @throws IOException
     *             - throws when the target dir could not be created or
     *             Javascript file creation fail.
     *
     * @see web.xml 'br.com.caelum.vraptor.encoding' parameter
     */
    private void deployI18nJavascriptFile(ResourceBundle bundle) {
        if (bundle != null) {
            try {
                Enumeration<String> enumeration = bundle.getKeys();

                String keys = "\t\t";
                int i = 0;
                while (enumeration.hasMoreElements()) {
                    String key = enumeration.nextElement();

                    if (i > 0 && i % 3 == 0) {
                        keys += "\n\t\t";
                    }

                    // Fix quotation marks and break lines of an String.
                    String traducao = bundle.getString(key).replaceAll("'", "\'");
                    traducao = traducao.replaceAll("\\n", "\\\\n");

                    keys += "m[\"" + key + "\"] = \"" + traducao + "\";\n\t\t";
                    i++;
                }

                if (keys.length() > 2) {
                    if (keys.endsWith("\t\t")) {
                        keys = keys.replaceAll("\t\t$", "\t");
                    }

                    String plugin = "jQuery( function($)\n";
                    plugin += "{\n";
                    plugin += "\t$.msg = function (key)\n";
                    plugin += "\t{\n";
                    plugin += "\t\tvar m = new Array();\n\n";
                    plugin += keys;
                    plugin += "\n\t\tvar msg = m[key];\n\t";
                    plugin += "\n\t\tmsg = (msg == undefined) ? ('??[' + key + ']??') : msg;\n\t";
                    plugin += "\n\t\treturn msg;\n\t";
                    plugin += "}\n";
                    plugin += "});";

                    // Write content to new Javascript file.
                    this.createI18nJavascriptFile(plugin, bundle.getLocale());
                }
            } catch (IOException e) {
                logger.error("Error ao gerar arquivos de mensagem", e);
            } catch (Exception e) {
                logger.error("Error ao gerar arquivos de mensagem", e);
            }
        }
    }

    /**
     * This method creates an new Javascript file with the jQuery plugin content
     * ($.msg). If the file exists, the same will be replaced.
     *
     * @param content
     *            - The jQuery plugin content.
     *
     * @param locale
     *            - Locale to set a name of file. E.g: messages_pt_BR.properties
     *
     * @throws IOException
     *             - For file operations.
     */
    private void createI18nJavascriptFile(String content, Locale locale) throws IOException {
        // Ensures that the file is at the root of WebContent
        File root = new File(this.context.getRealPath("/"));

        File dir = new File(root.getCanonicalPath() + File.separator + "js" + File.separator + "i18n" + File.separator);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        if (!dir.exists()) {
            throw new IOException("Could not create the destination folder of i18n javascript files.");
        }

        if (locale.getLanguage().isEmpty()) {
            locale = DEFAULT_LOCALE;
        }
        File js = new File(root.getCanonicalPath() + File.separator + "js" + File.separator + "i18n" + File.separator
                + "messages_" + locale + ".js");

        // Delete and create.
        if (js.exists()) {
            js.delete();
        }
        js.createNewFile();

        String charset = this.context.getInitParameter("br.com.caelum.vraptor.encoding");

        if (charset == null || charset.isEmpty()) {
            charset = "UTF-8";
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(js), charset));

        bw.write(content);
        bw.close();
        logger.info("The file " + js.getName() + " was deployed successfully.");
    }
}
