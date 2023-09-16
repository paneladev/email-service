## Serviço para envio de e-mails

Serviço desenvolvido para fazer o envio de email simples, contendo apenas um destinatário, título e corpo do email, utilizando Java Spring Boot.

Neste repositório existem dois exemplos distintos de envio de email, que estão separados por branch, conforme abaixo.

### Branch: `send-email-gmail`

Nesta branch utilizamos o JavaMailSender para fazer o envio de email utilizando o próprio Gmail

### Branch: `send-email-aws`

Nesta branch utilizamos o serviço SES da AWS para enviar e-mail, utilizando a própria biblioteca da AWS chamada `aws-java-sdk-ses` e também utilizando o conceito de clean architecture.
Este código foi feito a partir do vídeo da [Fernanda Kipper](https://github.com/Fernanda-Kipper) que está disponivel no [youtube](https://www.youtube.com/watch?v=eFgeO9M9lLw).