package com.ojs.ordemservico.services;

import com.ojs.ordemservico.config.exception.ResourceForbidenException;
import com.ojs.ordemservico.config.exception.ResourceNotFoundException;
import com.ojs.ordemservico.entities.Evolucao;
import com.ojs.ordemservico.entities.OrdemServico;
import com.ojs.ordemservico.entities.Usuario;
import com.ojs.ordemservico.repository.EvolucaoRepository;
import com.ojs.ordemservico.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EvolucaoServiceImpl implements EvolucaoService {

    @Autowired
    private EvolucaoRepository evolucaoRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Override
    @Transactional
    public Evolucao save(Evolucao evolucao) throws ResourceNotFoundException, ResourceForbidenException {

        // recupera a ordem de serviço exite
        Optional<OrdemServico> ordemServicoOptional = ordemServicoRepository.findById(evolucao.getOrdemServico().getId());
        if (!ordemServicoOptional.isPresent()) {
            throw new ResourceNotFoundException("Ordem de serviço não encontrada: " + evolucao.getOrdemServico().getId());
        }

        // validando se usuário logado pode realizar esta operação
        UserDetails userDetails = ((Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (!Objects.equals(((Usuario) userDetails).getId(), ordemServicoOptional.get().getResponsavel().getId())) {
            throw new ResourceForbidenException("Você não é reponsável da ordem de serviço.");
        }

        Evolucao evolucaoCriada = evolucaoRepository.save(evolucao);

        // faz a alteração do estado na ordem de serviço
        if (evolucao.getStatus() != null) {
            ordemServicoOptional.get().setStatus(evolucao.getStatus());
            ordemServicoRepository.save(ordemServicoOptional.get());
            evolucaoCriada.setOrdemServico(ordemServicoOptional.get());

        }

        return evolucaoCriada;
    }

    @Override
    public List<Evolucao> findByOrdemServicoId(Long ordemServicoId) {
        return evolucaoRepository.findByOrdemServicoId(ordemServicoId,
                Sort.by(Sort.Direction.DESC, "data"));
    }
}
