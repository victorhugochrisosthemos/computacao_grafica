# Algoritmo de Bresenham
- Criado por Jack Elton Bresenham
- É um algoritmo utilizado para desenhar linhas em matrizes, calcula quais pixels devem ser coloridos para formar uma linha entre dois pontos
- Ele é usado para rasterizar linhas
- O que é rasterizar? É um processo de desenhar uma linha em uma grade de pixels, aproximando a imagem à linha desejada
- O algoritmo é considerado eficiente porque evita o uso de operações com ponto flutuante, utilizando apenas operações inteiras e diminuindo a a necessidade de muito processamento
- Na prática, você vai escolher dois pontos e o algoritmo vai desenhar a linha, a distância entre eles

## Como ele funciona?
- Ele calcula as diferenças entre as coordenadas x e y dos dois ponto
- Determina a direção da geração dos pixels a serem desenhados
- Usa um indicador de erro para decidir quando incrementar no eixo y
- Fica assim até chegar no ponto final da reta

## Bibliotecas usadas
- **java.awt**: Bilioteca 'Abstract Window Toolkit', usada para gerenciar layouts, cores e graficos
- **java.awt.event**: Biblioteca para lidar com eventos do mouse
- **java.util***: Biblioteca para lidar com estruturas de dados como ArrayList
- **javax.swing**: Foi utilizado a bilioteca Swing para criar botões de limpar a tela e o botão para encerrar a aplicação (classe JButton)
