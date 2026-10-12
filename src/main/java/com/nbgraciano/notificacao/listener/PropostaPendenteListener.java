package com.nbgraciano.notificacao.listener;


import com.nbgraciano.notificacao.constante.MensagemConstante;
import com.nbgraciano.notificacao.domain.Proposta;
import com.nbgraciano.notificacao.service.NotificacaoSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {

    private NotificacaoSnsService notificacaoSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaPendente(Proposta proposta){
        String mensagem =String.format(MensagemConstante.PROPOSTA_EM_ANALISE,proposta.getUsuario().getNome());
        notificacaoSnsService.notificar(mensagem);
    }
}
