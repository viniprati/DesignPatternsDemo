# Design Patterns Demo

Projeto em Java que demonstra a aplicação prática de três padrões de projeto clássicos:

* **Singleton** — Garantia de única instância (exemplo: Logger)
* **Factory Method** — Criação flexível de objetos (exemplo: veículos)
* **Observer** — Sistema de notificação para eventos (exemplo: monitoramento de veículos)

## Como funciona

O programa cria veículos (carro e moto) usando fábricas específicas, registra eventos de direção através de um sistema de observadores e utiliza um logger singleton para exibir mensagens no console.

## Como executar

1. Salve o arquivo `DesignPatternsDemo.java`.
2. Compile:

```bash
javac DesignPatternsDemo.java
```

3. Execute:

```bash
java DesignPatternsDemo
```

## Saída esperada

```
Car is driving
[LOG] Vehicle event: Car started driving
Motorcycle is driving
[LOG] Vehicle event: Motorcycle started driving
```

## Padrões aplicados

* **Singleton**: `Logger` — garante uma única instância para registro de logs.
* **Factory Method**: `VehicleFactory` e subclasses — criam objetos de veículos sem expor a criação diretamente.
* **Observer**: `VehicleEventNotifier` e `VehicleObserver` — permitem notificar interessados quando um evento ocorre.
