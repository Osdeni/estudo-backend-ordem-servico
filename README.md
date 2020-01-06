# Ordem de serviço - Estudos e Aprendizado

### Publicação em nuvem:
    http://34.95.145.32:8082
        * Google cloud console
        * Docker e Kubernetes
        * referências: (https://github.com/Osdeni/kubernets-gcp)

- Recursos utilizados:
    * Git e Gitflow
    * Maven para gerenciamento das dependências;
    * JPA com Hibernate
    * Mysql com base via docker-compose;
    * Documentação da API com swagger;
        * http://34.95.145.32:8082/api/swagger-ui.html
    * Habilitado actuator para avaliação de saúde do serviço;
        * http://34.95.145.32:8082/api/actuator/health
    * Autenticação com JWT;
    * Liberação de CORS para aplicação de front-end (por momento *)
    * Querysql nas api de listagem de ordem de serviços;
    * Interceptação e tratamento de exceções dos erros para formas mais simplificads;
    * Uso da camada de service;
    * Uso de DTO para não transitar as entities;
    * Usado ENUM nos status de ordem de serviço, podendo posteriormente ser realizado em banco de dados;
    * Proteção e permissão de rotas para ROLES específicos;
        * ROLE_ATENDIMENTO: 
            * Pode criar ordem de serviço e clientes, mas não pode "iniciar execuções de serviço";
        * ROLE_TECNICO:
            * Pode iniciar apenas as "SUAS" ordens de serviços, mas não pode Criar uma ordem de serviço;
        * retornos 403 nestes casos
    * Uso de transação no caso do cadastro das "Evoluções" das ordens de serviço, ao gerar uma nova "evolução/atendimento" ele também atualiza o status na ordem de serviço;
    * Criação de testes de integração de todos os endpoinsts das api em conjunto com a suíte AppTest;
    * Definição do timezone para America/Sao_Paulo
   
   
## Dados de acessos:
    Nuvem: http://34.95.145.32:8082/api/
    Local: http://localhost:8082/api/

    func1@gmail.com:
    senha: secret
    Role: ATENDIMENTO(Pode criar ordens)
        
    func2@gmail.com e func3@gmail.com:
    senha: secret
    Role: TECNICO (Pode dar seguimento nas evoluções das SUAS ordens de serviços)