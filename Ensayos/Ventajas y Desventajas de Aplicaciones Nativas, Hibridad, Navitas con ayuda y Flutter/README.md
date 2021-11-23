# Ventajas y Desventajas de Aplicaciones Nativas, Hibridad, Navitas con ayuda y Flutter

---

# Aplicaciones Nativas

Cada aplicación nativa tiene recursos definidos por el sistema operativo, estos pueden ser recursos lógicos (seguridad), sensores o alguna relación dependiente con el hardware. Los lenguajes para desarrollar aplicaciones nativas son:

- Android: Kotlin o Java
- iOS: Swift u Objetive-C
- Windows Phone: .Net o C++

La descarga de estas aplicaciones se realiza desde las diferentes Tiendas de Aplicaciones que implemente el sistema operativo

<aside>
👉 Las aplicaciones nativas están capacitadas para adaptarse al 100% a las funcionalidades del móvil y acceder a la mayoría de características hardware

</aside>

<aside>
❌ El mayor inconveniente que podemos encontrar en el desarrollo de una aplicación nativa es que tiene un coste más elevado. Eso hace que su precio se multiplique, dependiendo de los sistemas a los que queramos adaptar nuestra aplicación.

</aside>

# Aplicaciones Hibridas

Las aplicaciones hibridas son aquellas que combinan elementos de aplicaciones web y aplicaciones nativas. Estas corren sobre un shell de aplicación nativo. Una vez que se descargan de una tienda de aplicaciones y se instalan localmente, el shell puede conectarse a cualquier capacidad que brinde la plataforma móvil a través de un navegador integrado en la aplicación. El navegador y sus complementos se ejecutan en el Backend y son invisibles para el usuario final.

Las aplicaciones híbridas son populares porque permiten a los desarrolladores escribir código para una aplicación móvil una vez y aún se adaptan a múltiples plataformas. Debido a que las aplicaciones híbridas agregan una capa adicional entre el código fuente y la plataforma de destino, pueden funcionar un poco más lento que las versiones nativas o web de la misma aplicación.

<aside>
✅ Las aplicaciones hibridas poseen un tiempo de combinación mucho más rápido que las aplicaciones nativas, reducen costos al momento de desarrollo y son más fáciles de actualizar

</aside>

<aside>
❌ La apariencia puede variar entre dos sistemas operativos diferentes, la experiencia de usuario se ve afectada puesto que requiere probar en un número considerable de dispositivos. Además, se ven afectadas en el rendimiento puesto que dependen de un navegador para su correcto funcionamiento

</aside>

# Aplicaciones Nativas con ayuda (Multiplataforma)

El desarrollo multiplataforma procura optimizar la relación costo/beneficio compartiendo la misma codificación entre las versiones para las distintas plataformas. Entre otras ventajas sobresalen: menor tiempo y costo de desarrollo; prestaciones similares a las nativas con acceso al hardware del dispositivo, y disponibilidad de entornos potentes de desarrollo (Delphi, Visual Studio, etc.) o; en su lugar, utilización de tecnologías (HTML5, Javascript y CSS) bien conocidas por los desarrolladores web quienes pueden trasladar sus conocimientos y experiencias al paradigma móvil. Sin embargo, el rendimiento de las aplicaciones y sus interfaces de usuario, pueden afectar la experiencia de usuario.

Las aplicaciones móviles multiplataforma son aquellas que se desarrollan en un lenguaje de programación general y que luego se puede «compilar» o «exportar» a cualquier plataforma o dispositivo con unos cambios mínimos. Es una manera de abaratar costes de desarrollo y mantenimiento, ya que generar aplicaciones móviles de forma nativa implica programar en diferentes lenguajes y entornos para cada sistema operativo (iOS, Android, Windows)

<aside>
✅ Aumentan la reutilización de código y disminuyen los costos de producción

</aside>

<aside>
❌ Depende de un alto grado de compatibilidad con los sistemas dependiendo de las versiones base del sistema donde serán instaladas.

</aside>

<aside>
❌ El proceso para ingresar a las diversas tiendas de Aplicaciones se complica, puesto que cada una pone clausulas diferentes

</aside>

# Aplicaciones con Flutter

Flutter es un framework para desarrollar aplicaciones para diferentes plataformas elaborado por Google y publicado por primera vez como proyecto de código abierto a finales de 2018. Este kit de desarrollo ofrece un gran número de bibliotecas para elementos estándar de la interfaz de usuario de Android y iOS, pero también sirve para desarrollar aplicaciones web de escritorio. Las aplicaciones desarrolladas con Flutter tienen el aspecto normal de las aplicaciones en cada sistema y se comportan como se espera de ellas en todos ellos sin que los programadores tengan que prestar atención a las particularidades de cada sistema.

Flutter se usa principalmente para desarrollar aplicaciones de Android y iOS sin necesidad de escribir un código base propio para cada uno de estos sistemas, completamente diferentes entre sí. En este contexto, las aplicaciones móviles se ejecutan como auténticas aplicaciones nativas en los dispositivos. Antes de su publicación, se compilan para la plataforma correspondiente, de manera que no necesitan un módulo runtime ni un navegador.

<aside>
✅ Con una base de código podemos llegar a diferentes plataformas. Adicional, implementa bibliotecas con elementos gráficos prefabricados con la finalidad de facilitar la programación y mejorar la experiencia del usuario

</aside>

<aside>
❌ Al ser todo un widget, el código tiende a causar confusión.

</aside>

<aside>
❌ En el caso de que se produzca una gran actualización los widgets tienes que ser actualizados y la aplicaciones tiene que volver a ser recompilada

</aside>