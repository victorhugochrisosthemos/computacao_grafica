# Tensor Core

- Estudos sobre Tensor Core para apresentação do seminário de Computação Gráfica, avaliação M1.1
## 1. Arquitetura e funcionamento dos Tensor Cores

- O que é Tensor Core? São regiões de hardwares de computação gráfica (GPUs) da NVIDIA que aceleram a multiplicação de matrizes
- Como é feito a aceleração de multiplização de matrizes?

<br>-->Realiza o processamento dos elementos da matriz em blocos simultaneamente, beneficiando-se do paralismo computacional
<br><br>-->As operações matriciais são otimizadas definindo formatos numéricos diferentes. Um exemplo é que se uma GPU normal utiliza precisão FP32 (4 bytes por número) e o GPU da NVIDIA usa FP16(2 bytes por número), o processo irá ocupar metade da memória permitindo processar o dobro de dados no mesmo espaço de tempo
<br><br>-->Usa Pipeline de Operações FMA. Fused Multiply-Add (FMA) é uma operação matemática que combina multiplicação e soma em uma única etapa, reduzindo acessos à memória, operações e erros de arredondamento
<br><br>-->Registradores e memória possuem alta largura de banda, isso permite que dados intermediários sejam mantidos próximos ao núcleo de processamento e evitam acessos desnecessários a níveis mais baixos da memória da GPU

![image](https://github.com/user-attachments/assets/d11f3b5e-580f-42df-98e4-27df7c5704a4)
<br>**Arquitetura do Tensor Core**

<br><br>

![image](https://github.com/user-attachments/assets/88b7252d-a038-487a-8eb5-2644bf13f599)
<br>**Multiplicação de matrizes com precisão mista**
<br><br>

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

- O que são operações MMA e IMMA? Mixed-Precision Matrix Multiply-Accumulate (MMA) e Integer Mixed-Precision Matrix Multiply-Accumulate(IMMA) são etapas de prrocessamento de dados nos Tensor Cores, realizando multiplicação de matrizes com precisão mista, operações FMA e processos paralelizados. O processo MMA é relativo a precisão mista com ponto flutuante e IMMA referente a precisão mista com números inteiros
  

<br>

## 2. Aplicações e evolução dos Tensor Cores

- Tensor Cores foram utilizados pela primeira vez na arquitetura Volta (V100)
<br>
![image](https://github.com/user-attachments/assets/0be8de63-a27d-4410-a7c8-9f67d6a4a9a7)
<br>
- Houve melhorias nas arquiteturas Turing (RTX 20XX) e Ampere (RTX 30XX)
- Houve mais melhorias nas arquiteturas Hopper (H100) e Ada Lovelace (RTX 40XX)
- Quais atividades/áreas são beneficiadas pelos Tensor Cores?
  
<br><br>-->Para treinamento de redes neurais, os processos de Forward Pass (multiplicação de pesos com os inputs) e Backpropagation (atualização dos pesos da rede neurall) são beneficiados pelos formatos numéricos dando mais precisão e menos dependendo do cenário
<br><br>-->Profissionais da computação gráfica e animação para renderização de seus projetos 3D. O processo de renderização da técnica Ray Tracing (melhoria da qualidade visual 3D permitindo cenários fotorrealistas) necessita de um poder de processamento considerável, o cálculo da direção dos raios luminosos a 30-60 quadros por segundo em tempo real é inviável em muitos PCs, mas o Tensor Core com uso da técnica IA denoising consegue suportar essa demanda
<br><br>IA DENOISING: Técnica que usa modelos de aprendizado de máquina para prever e remover imperfeições/ruído de uma imagem, a partir de um número limitado de raios iniciais. Nesse caso, o Tensor Core acelera processos da rede neural de denoising
<br><br>-->Empresas de automação e engenharia, para [automação e simulações](https://www.nvidia.com/pt-br/autonomous-machines/robotics/) usando Machine Learning
<br><br>-->Hoje (01/03/25) sistemas computacionais de alto desempenho (High-Performance Computing -> HPC), de maneira geral, possuem como parte de sua composição o uso de GPUs da NVIDIA com Tensor Cores. Esses sistemas são utilizados para simulações na área de pesquisa científica ou em cluesters de servidores, por exemplo

- Outras empresas também possuem tecnologias semelhantes

<br>--> AMD: Linhas RDNA e CDNA de GPUs com os chamados Matrix Cores
<br><br>--> Intel: Com tecnologia semelhante na arquitetura Xe
<br><br>--> Apple: Com a Neural Engine nos chips A11 Bionic, M1, M2
<br><br>--> Google: Criou as TPUs (Tensor Processing Units), muito semelhantes com a tecnologia Tensor Core da NVIDIA
<br><br>--> Huawei: Com unidades de aceleração de IA chamadas Ascend Processors

## 3. Programação com Tensor Cores

- Como os Tensor Cores são utilizados na programação?

<br>--> De acordo com o que foi destacado anteriormente, os Tensor Cores tem como finalidade principal agilizar multiplicações de matrizes. Para programar essas operações feitas em GPU, é utilizada a arquitetura CUDA, que serve como base para a programação paralela nas GPUs. Essa ferramenta permite acesso direto aos tensor Cores por meio de extensões específicas, como a API CUDA WMMA (Warp Matrix Multiply-Accumulate), que possibilita executar as operações citadas anteriormente nos formatos numéricos suportados.
<br><br>-->Além de utilizar a arquitetura CUDA diretamente, existem ferramentas que facilitam o uso dos Tensor Cores na programação. Alguns exemplos são:
- cuDNN => Otimiza operações de redes neurais utilizando dos Tensor Cores automaticamente quando disponíveis no hardware.
- TensorRT => Aprimora a eficiência de modelos de IA utilizando Tensor Cores para maximizar o desempenho.
- Frameworks de IA => Fazem o uso do que foi apresentado anteriormente para agilizar operações, geralmente relacionadas com IA ou machine learning, sem a necessidade de entrar em um nível mais baixo de programação. PyTorch e TensorFlow são exemplos.

## 4. Desempenho, desafios e limitações

#### Referências:
- https://www.nvidia.com/pt-br/data-center/tensor-cores/
- https://developer.nvidia.com/blog/programming-tensor-cores-cuda-9/
