# Tensor Core

- Estudos sobre Tensor Core para apresentação do seminário de Computação Gráfica, avaliação M1.1
## Arquitetura e funcionamento dos Tensor Cores

- O que é Tensor Core? São regiões de hardwares de computação gráfica (GPUs) da NVIDIA que aceleram a multiplicação de matrizes
- Como é feito a aceleração de multiplização de matrizes?

<br>-->Realiza o processamento dos elementos da matriz em blocos simultaneamente, beneficiando-se do paralismo computacional
<br><br>-->As operações matriciais são otimizadas definindo formatos numéricos diferentes. Um exemplo é que se uma GPU normal utiliza precisão FP32 (4 bytes por número) e o GPU da NVIDIA usa FP16(2 bytes por número), o processo irá ocupar metade da memória permitindo processar o dobro de dados no mesmo espaço de tempo
<br><br>-->Usa Pipeline de Operações FMA. Fused Multiply-Add (FMA) é uma operação matemática que combina multiplicação e soma em uma única etapa, reduzindo acessos à memória, operações e erros de arredondamento
<br><br>-->Registradores e memória possuem alta largura de banda, isso permite que dados intermediários sejam mantidos próximos ao núcleo de processamento e evitam acessos desnecessários a níveis mais baixos da memória da GPU

- Quais são os formatos numéricos suportados?



  <br>-->FP16: Ponto flutuante de 16 bits
  <br>-->TF32: Ponto flutuante de 32 bits com exponente de 10 bits e mantissa de 8 bits
  <br>-->FP32: Ponto flutuante de 32 bits
  <br>-->INT8: Números inteiros de 8 bits
  <br>-->INT4: Números inteiros de 4 bits
  <br>-->Bfloat16: Ponto flutuante de 16 bits similar ao FP16, mas com uma distribuição diferente entre o exponente e a mantissa, com 8 bits de exponente e 7 bits de mantissa
  
<br>**Lembra o que é mantissa né?

![image](https://github.com/user-attachments/assets/64ea0e46-465c-4434-8e94-c1a563bd187b)

<br>
- O que são operações MMA? Mixed-Precision Matrix Multiply-Accumulate (MMA) são etapas de prrocessamento de dados nos Tensor Cores, realizando multiplicação de matrizes com precisão reduzida e utilizando operações FMA
  
- Quais atividades/áreas são beneficiadas pelos Tensor Cores?
  
<br>-->Para treinamento de redes neurais, os processos de Forward Pass (multiplicação de pesos com os inputs) e Backpropagation (atualização dos pesos da rede neurall) são beneficiados pelos formatos numéricos dando mais precisão e menos dependendo do cenário
<br>-->Profissionais da computação gráfica e animação para renderização de seus projetos 3D
<br>-->Empresas de automação e engenharia, para [automação e simulações](https://www.nvidia.com/pt-br/autonomous-machines/robotics/) usando Machine Learning
