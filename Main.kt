import java.util.concurrent.ConcurrentLinkedDeque
import kotlin.concurrent.thread

var semaforoAberto = true //ta aqui em cima pois como vou trabalhar com threads, todas elas precisam saber se o semáforo vai ta ou n aberto
var filaCarros = ConcurrentLinkedDeque(listOf("golf", "camaro", "corvette", "jetta")) //criação da lista    //n vou mentir, o concurrenrlinkdequee é coisa do chat, eu n tava conseguindo, mas sei que é pq mais de uma thread estavam tentando acessar a msm var ao msm tempo
var carrosChegada = listOf(
    "civic",
    "gol",
    "onix",
    "porsche 911",
    "hb20",
    "lancer",
    "azera",
    "corolla",
    "creta",
    "hilux",
    "mc laren"
) //lista de carrinhos pra chegar, sendo um por vez

fun main() {
    println("=====SEMÁFORO=====")
    controleSemaforo()
    chegadaCarros()
    saidaCarros()
}

fun controleSemaforo() {
    thread {
        while (true) {
            println("o semáforo está aberto")
            Thread.sleep(5000) //numero x 1000 pq é em mili segundos, 5000 ms == 5 s

            semaforoAberto = false   //depois dos 5 segundos dele fechado, o semáforo aberto nao vai mais ser vdd, por isso false, e quando for falso, ele vai ta fechado por 10 segundos
            println("o semáforo está fechado")
            Thread.sleep(10000)
            semaforoAberto = true
        }
    }
}

fun chegadaCarros() {

    thread {
        while (true) {
            val carroAleatorio = carrosChegada.random()

            filaCarros.addLast(carroAleatorio) //vai adicionar um carro no FINAL DA FILA por isso LAST, pq foi o ultimo a chegar
            Thread.sleep(3000) //o carro tem que esperar, até pq n tem como passar por cima dos outros carros ne pq quero que saia um por vez só
            println("🚗 chegou ${carroAleatorio} | fila  (${filaCarros.size}) | ${filaCarros}   ") //aqui pra mostrar a lista no console em cada volta do loop
        }
    }
}

fun saidaCarros() {
    thread {
        while (true) {
            if (semaforoAberto && filaCarros.isNotEmpty()) {
                val carro = filaCarros.removeFirst()  //filaCarros.removeFirst() //remove o PRIMEIRO carro, por isso FIRST, o primeiro da fila foi o primeiro a sair
                println("🚗 passou o carro ${carro} | fila (${filaCarros.size}): $filaCarros")
            }
            Thread.sleep(2000) // tempo entre carros passando
        }
    }
}


