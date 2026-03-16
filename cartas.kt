//TRABALHO DE WESLEY RA 60005120
var cartas = (1..20).toMutableList()   //aqui em cima de novo, pois vai ser uma lista universal, que em qualquer função tem q ser a msm.. (1..20).toMutableList() é pra fazer uma lista do numero 1 ate o 20 mutavel
val pilha = ArrayDeque<Int>()
fun main(){
    //println("baralho normal ${cartas}")
    embaralharCartas()
   // println("agora o baralho está embaralhado ${cartas}")
    botarNaPilha()
  /*  println(pilha.last()) //vai mostrar qual a ultima carta adicionada na pilha a do topo
    pilha.removeLast() // vai tirar a ultima carta que foi adicionada no topo, no caso, a ultima (L ast) a entrar (I n) foi a primeira (F irts) a sair (O ut) LIFO
    println(pilha)
    println(pilha.last()) */
    println("==========JOGO DA ADIVINHAÇÃO==========")
    jogar()
    println("deseja jogar de novo??")
    var desejaOuNao = readln().toString()
    when(desejaOuNao){
        "sim" ->{
            embaralharCartas()
            botarNaPilha()
            jogar()}
        "nao"->{println ("até a proxima")}
    }

}


fun embaralharCartas(){
    cartas.shuffle() //shuffle é pra "embaralhar", no caso mistura a ordem
}


fun botarNaPilha(){
    for (carta in cartas){
        pilha.add(carta) //para carta(variavel de 1 em 1) em cartas ir adicionando uma carta no topo ate acabar a pilha (20 cartas) o .add é pra adicionar obviamente kkkkk
    }

}

fun jogar(){
    var pontos = 0
    while (pilha.isNotEmpty()){ //enquanto pilha nao está vazia
        println("cartas restantes ${pilha.size}")
        println("qual carta você acha que está no topo? ")
        var tentativa = readln().toInt()
        if (tentativa == pilha.last()){
            println("parabénsss vc acertou :)")
            pontos++
        } else{
            println("você errou, sinto muito :( , a carta correta era ${pilha.last()} ")

        }
        pilha.removeLast()
    }
    println("o jogo chegou ao fim")
    println("Sua pontuação foi ${pontos}")
}