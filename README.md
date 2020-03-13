# Projeto para MEGA-SENA

Nesse projeto duas classes principais:
* GeradorJogo
* CalcularResultadoJogo

A primeira classe é responsável por gerar o jogo e salvar em um arquivo texto caso as propriedades estejam configuradas.

A segunda classe é responsável por calcular o resultado do jogo.

### Config.properties

O arquivo de configurações possui as seguintes propriedades:

| Propriedade | Possível valor | Descrição |
| :---: | :---: | :---: |
| jogo.quantidade_numero_por_jogo | 6 | A quantidade de números que será utilizado no jogo |
| jogo.quantidade_jogos_gerado | 3000000 | Quantidade de números para serem gerados |
| jogo.premio_quadra | 1099.78 | Valor do prêmio da quadra |
| jogo.premio_quina | 57537.06 | Valor do prêmio da quina  |
| jogo.premio_sena | 76000000.00 | Valor do prêmio da sena  |
| jogo.preco | 4.50 | Valor da cartela da Mega sena  |
| jogo.resultado | 03,35,38,40,57,58 | Números ganhadores da mega sena |
| jogo.min_qtd_acertos | 4 | Menor quantidade de jogos validos, por exemplo: 6, só contabilizará se fizer sena.  |
| file.separador_numeros | , | Separador dos números para realizar o calculo do resultado do jogo.  |
| file.caminho_salvar_arquivo | jogo.txt | Caminho para salvar o arquivo. Caso esse valor esteja preenchido, então será salvo caso seja executado o código de geração dos jogos.  |
| file.caminho_carregar_arquivo | jogo.txt |  Caminho para ler o arquivo para calcular o resultado do jogo.  |

