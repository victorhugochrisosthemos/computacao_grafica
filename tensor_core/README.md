# Tensor Core
- Estudos sobre Tensor Core para apresentação do seminário de Computação Gráfica, avaliação M1.1
## Arquitetura e funcionamento dos Tensor Cores
- O que é Tensor Core? São regiões de hardwares de computação gráfica (GPUs) da NVIDIA que aceleram a multiplicação de matrizes
- Como é feito a aceleração de multiplização de matrizes?
<br>-->Está relacionado com o modo que o hardware trata operações **fused multiply-add (FMA)**, processando os elementos da matriz em blocos simultaneamente, faz o processamento dos dados em paralelo
<br>-->As operações matriciais são otimizadas definindo formatos numéricos diferentes. Os formatos suportados são FP16, TF32 e INT8. Um exemplo é que se uma GPU normal utiliza precisão FP32 (4 bytes por número) e o GPU da NVIDIA usa FP16(2 bytes por número), o processo irá ocupar metade da memória permitindo processar o dobro de dados no mesmo espaço de tempo
<br>-->Usa Pipeline de Operações FMA. Fused Multiply-Add (FMA) é uma operação matemática que combina multiplicação e soma em uma única etapa, reduzindo acessos à memória, operações e erros de arredondamento
