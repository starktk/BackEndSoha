## Authentication-Soha
*Sistema de validação e geração de token para login.*

## Como rodar localmente
- Necessário instalar o Postgresql https://www.postgresql.org/download/
- Clone este repositório
- Escolha uma ide de sua preferencia(Irei utilizar o Intellj como referência)
- Abra o projeto com o IntelliJ, e verifique se a "application.yml" ( src> main > resources > application.yml ) está configurado conforme Application.yml.
- Configure na pasta application.yml a password e o username como foi configurado na instalação do Postgresql
- O Projeto roda na porta default 8080, caso preferir alterar será necessário adcionar o corpo (Server: port:) no recurso application.yml ( src> main > resources > application.yml )

## Obs
- Já possui um usuário pré cadastrado ("raul@gmail.com", "raulzin"), porém se preferir há um endpoint para registrar pelo postman/insomnia

## Tecnologias
- Spring Lombok
- Spring Web
- Spring Security
- Spring Data Jpa
- JWT Token
- Postgresql

## Utilização
- Spring Web Utilizado para fazer conexões com Front-end dispinibilizando a camada de controle para o backend
- Lombok Utilizado para tornar objetos compactos e efetuar o clean code dos ObjectsModels
- Spring Security Utilizado para configuração e autorização de requests Http.
- JWT Token Utilizado para gerar, validar token e extrair dados do token.
- -Postgresql Utilizado para armazenamento seguro de passwords encriptadas sendo possivel escalabilidade e integração com outros modulos de outra Aplicação
- Spring Data Jpa Utilizado para abstrair e criar conecções websocket com database e fornece querys estruturadas.
- Maven Utilizado para gerenciamento de dependencias e do projeto.
