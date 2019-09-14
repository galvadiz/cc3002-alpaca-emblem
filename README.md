# cc3002 - alpaca-emblem


Este es el proyecto Alpaca Emblem, desarrollado utilizando Java 10 SDK. Incluye todos los archivos que implementan lo solicitado para este trabajo. Aquí puede ver el diagrama de clases Java UML. Para verla mejor, favor referirse al archivo uml_diagram.png en la carpeta raíz del proyecto en Github.

![Alt text](uml_diagram.png "UML")

## Diseño

### IEquipableItem interface
<p align="justify">

Se implementó una interfaz IEquipableItem. La interfaz permite a todas las armas comportarse como un item. Esto también permite una interacción de diseño double-dispatch cuando un itemes equipado a una unidad o cuando se ataca a otro item. También permite llevar en el almacenamiento interno de las unidades diferentes armas/items.
</p>

#### AbstractEquipableItem

<p align="justify">
Esta clase abstracta implementa la interfaz IEquipableItem. Las clases Axe, Bow Spear, Staff, Sword se implementaron utilizando la clase AbstractEquipableItem. Los métodos que comienzan con equipTo interactuan con la unidad con una interacción de diseño de double-dispatch, que permite a la unidad llamar el método adecuado para equipar el item.

Los métodos attackTo y los que comienzan con receiveAttack/receiveContraAttack interactúan con la unidad y su item con una interacción de diseño de double-dispatch. Esto permite recibir el tipo de ataque adecuado de cada item.
</p>

#### IMagia interface
<p align="justify">
Esta interfaz describe el comportamiento de los items mágicos (libros mágicos). Permite utilizar los diferentes tipos de items magicos en los métodos de manera diferenciada a las armas normales.
</p>

##### AbstractMagia

<p align="justify">
Esta clase abstracta implementa la interfaz IMagia y extiende la clase AbstractEquipableItem. Anima, Luz y Oscuridad se implementaron utilizando la clase AbstractMagia. 
</p>


### IUnit interface
<p align="justify">

Se implementó una interfaz IUnit. La interfaz permite los distintos personas del juego comportarse de la misma manera, como una unidad. Esto también permite una interacción de diseño double-dispatch cuando una unidad se equipa un item o cuando ataca a otra unidad.
</p>

#### AbstractUnit

<p align="justify">
Esta clase abstracta implementa la interfaz IUnit. Las clases Alpaca, Archer, Cleric, Fighter, Hero, Sorcerer y SwordMaster se implementaron utilizando la clase abstracta AbstractUnit. Los métodos que comienzan con equip permiten que la unidad de equipe el item adecuado con le diseño double-dispatch.

Los métodos attack y los que comienzan con receiveAttack/receiveContraAttack interactúan con el item y su dueño con una interacción de diseño de double-dispatch. Esto permite recibir el tipo de ataque adecuado de cada unidad junto con su item.

Esta clase utiliza un ArrayList para almacenar los items que lleva consigo. 
</p>

## Testing

El testing se realizó usando JUnit 5 para la unit test, alcanzando un 96% de cobertura de líneas.
Para ejecutar todos los test, importe el proyecto git a su computador, ábralo con IntelliJ, vaya a la carpeta test, haga clic derecho y seleccione "Run 'All Test' with Coverage". Todos los 102 tests pasarán.

## Authors

* **Geraldine Alvadiz F.** - *Universidad de Chile* - [git repo](https://github.com/galvadiz/)



