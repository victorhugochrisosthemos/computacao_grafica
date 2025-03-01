# Tensor Core
- Estudos sobre Tensor Core para apresentação do seminário de Computação Gráfica, avaliação M1.1
## Arquitetura e funcionamento dos Tensor Cores
- O que é Tensor Core? São regiões de hardwares de computação gráfica (GPUs) da NVIDIA que aceleram a multiplicação de matrizes
- Como é feito a aceleração de multiplização de matrizes?
<br>-->Realiza o processamento dos elementos da matriz em blocos simultaneamente, beneficiando-se do paralismo computacional
<br>-->As operações matriciais são otimizadas definindo formatos numéricos diferentes. Os formatos suportados são FP16, TF32 e INT8. Um exemplo é que se uma GPU normal utiliza precisão FP32 (4 bytes por número) e o GPU da NVIDIA usa FP16(2 bytes por número), o processo irá ocupar metade da memória permitindo processar o dobro de dados no mesmo espaço de tempo
<br>-->Usa Pipeline de Operações FMA. Fused Multiply-Add (FMA) é uma operação matemática que combina multiplicação e soma em uma única etapa, reduzindo acessos à memória, operações e erros de arredondamento
- Para quê é utiliziado os Tensor Cores?
<br>-->Para treinamento de redes neurais, os processos de Forward Pass (multiplicação de pesos com os inputs) e Backpropagation (atualização dos pesos da rede neurall) são beneficiados pelos formatos numéricos dando mais precisão e menos dependendo do cenário
<br>-->Profissionais da computação gráfica e animação para renderização de seus projetos 3D
<br>-->Empresas de automação e engenharia, para [automação e simulações](https://www.nvidia.com/pt-br/autonomous-machines/robotics/) usando Machine Learning
