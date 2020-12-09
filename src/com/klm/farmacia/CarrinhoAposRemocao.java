package com.klm.farmacia;

public class CarrinhoAposRemocao {
    public static String carrinhoAposRemocao(String carrinho, int posicaoRemocao){
        String carrinhoAtualizado = "";
        String[] itens = carrinho.split("\n");
        for (int i=0; i< itens.length; i++){
            if(i != posicaoRemocao){
                carrinhoAtualizado = carrinhoAtualizado + itens[i] + "\n";
            }
        }
        return(carrinhoAtualizado);
    }
}
