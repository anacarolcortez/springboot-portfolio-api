# API "HireMe", em Java e Spring
[Aplicativo em construção, para estudo]
<p>Objetivo da API é gerar portfolio "metalinguístico", em que a própria aplicação apresenta as habilidades do programador nas stacks desejadas e o seu currículo.</p> 
<p>Por meio da API, um recrutador poderá consultar o candidato, seu currículo, agendar, alterar, listar e excluir pedidos de entrevistas. Para isso, ele deverá fazer um cadastro e login.</p>
<p>Ao agendar/alterar/excluir pedidos de entrevista, ambos receberão e-mail de confirmação com os dados do agendamento.</p>
<p>As APIs estão em desenvolvimento, utilizando Java, Springboot, Postgres, JUnit, Mockito, Autenticação, Mensageria (RabbitMq).</p>
<p></p>
<p>OBS: A API será publicada no Render, serviço gratuito. O servidor, contudo, é acionado sob demanda. Por exemplo, ao fazer uma requisição POST no endpoint de Entrevista (Inetrview), o Render sobe o servidor (o que justifica uma certa demora na reposta da primeira requisição). O servidor fica, após acionado, ativo por poucos minutos, voltando ao estado inativo até que uma nova requisição seja feita. Desta forma, optei por publicar todos os microsserviços juntos, ainda que o ideal seria publicar em separado, pelo menos, a API de envio de e-mail. Optei por esta solução para garantir o disparo do e-mail automático, ou seja, que o serviço de e-mail esteja online para consumir a fila no RabbitMq.</p>