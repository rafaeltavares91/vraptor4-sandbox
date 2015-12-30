(function ( $ ){
    var Notificador = function(_container, cfg) {

        var erros = cfg.erros,
            sucessos = cfg.sucessos,
            avisos = cfg.avisos,
            informacoes = cfg.informacoes,
            container = _container,
            notificador = this,
            ERRO = "erro",
            SUCESSO = "sucesso",
            AVISO = "aviso",
            INFORMACAO = "informacao";

        this.limparNotificacoes = function() {
            erros = [];
            sucessos = [];
            avisos = [];
            informacoes = [];

            self._repaint();
        }

        this.notificarErro = function(mensagem) {
            if (erros.indexOf(mensagem) < 0) {
                erros.push(mensagem);
                self._repaint();
            }
        }

        this.notificarSucesso = function(mensagem) {
            if (sucessos.indexOf(mensagem) < 0) {
                sucessos.push(mensagem);
                self._repaint();
            }
        }

        this.notificarAviso = function(mensagem) {
            if (avisos.indexOf(mensagem) < 0) {
                avisos.push(mensagem);
                self._repaint();
            }
        }

        this.notificarInformacao = function(mensagem) {
            if (informacoes.indexOf(mensagem) < 0) {
                informacoes.push(mensagem);
                self._repaint();
            }
        }

        var self = {
            _criarPainelNotificao : function() {
                var painelNotificao = document.createElement("div");

                var notificadorErros = self._criarNotificador(erros, "alert-danger", ERRO);
                var notificadorSucessos = self._criarNotificador(sucessos, "alert-success", SUCESSO);
                var notificadorAvisos = self._criarNotificador(avisos, "alert-warning", AVISO);
                var notificadorInformacoes = self._criarNotificador(informacoes, "alert-info", INFORMACAO);

                $(painelNotificao).append(notificadorErros);
                self._sobrescreverComportamentoClosePadrao(notificadorErros);
                $(painelNotificao).find("button[name= " + ERRO + "]").click(function() {
                    erros = [];
                });

                $(painelNotificao).append(notificadorSucessos);
                self._sobrescreverComportamentoClosePadrao(notificadorSucessos);
                $(painelNotificao).find("button[name= " + SUCESSO + "]").click(function() {
                    sucessos = [];
                });

                $(painelNotificao).append(notificadorAvisos);
                self._sobrescreverComportamentoClosePadrao(notificadorAvisos);
                $(painelNotificao).find("button[name= " + AVISO + "]").click(function() {
                    avisos = [];
                });

                $(painelNotificao).append(notificadorInformacoes);
                self._sobrescreverComportamentoClosePadrao(notificadorInformacoes);
                $(painelNotificao).find("button[name= " + INFORMACAO + "]").click(function() {
                    informacoes = [];
                });

                return painelNotificao;
            },

            _criarNotificador : function(mensagens, classeMensagem, nome) {
                var notificador = "";
                var classeVisibilidade = "";
                if (mensagens !== null && mensagens.length === 0) {
                    classeVisibilidade = "invisivel";
                }

                notificador += "<div name=\"" + nome + "\" class=\"" + classeVisibilidade + "\">";
                notificador += " <div name=\"" + nome + "\" class=\"alert alert-block " + classeMensagem + " fade in\">";
                notificador += "  <button name=\"" + nome + "\" data-dismiss=\"alert\" class=\"close close-sm\" type=\"button\">";
                notificador += "   <i class=\"fa fa-times\"><\/i>";
                notificador += "  <\/button>";
                notificador += "  <div class=\"notificacoes\">";
                mensagens.forEach(function(mensagem) {
                    notificador += "   <p class=\"notificao\">" + mensagem + "</p>"
                });
                notificador += "  </div>";
                notificador += " </div>";
                notificador += "</div>";

                return notificador;
            },

            _repaint : function() {
                var painelNotificao = self._criarPainelNotificao();

                container.empty();
                container.append(painelNotificao);
            },

            _contruirNotificador: function() {
                self._repaint();
            },

            _sobrescreverComportamentoClosePadrao : function (componente) {
                $(componente).on('close.bs.alert', function(event) {
                    event.preventDefault();
                    $(componente).find(".notificacoes").empty();
                    $(this).hide();
                });
            }
        }

        self._contruirNotificador();
    }

    $.fn.notificadorComponente = function( options ) {

        var cfg = $.extend({
            erros: [],
            sucessos: [],
            avisos: [],
            informacoes: []
        }, options );

        var notificadores = [];
        var elementos = $(this);
        elementos.each(function(i) {
            notificadores.push(new Notificador($(this), cfg));
        });

        if (notificadores != null && notificadores.length === 1) {
            return notificadores[0];
        } else {
            return notificadores;
        }
    };

}( jQuery ));