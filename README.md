# Hamcrest
> Asserts mas legibles, estilo ingles.
# Mockito
> Mockear objetos
# MockMvc
> Realizar http request-response

> Nota: @EnableJpaRepositories definirlo en clase @Configuracion separada de la clase que contiene el metodo main, ya que de esta manera cuando quieras testear la web-layer unicamente no se ejecuta esta anotacion. Y en caso de que se ejecute esta anotacion va a intentar crear los beans @Repository y para testear la web-layer no es lo que queres.
