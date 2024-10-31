EXAMEN
Cree un nuevo proyecto en el IDE con sus nombres y apellidos completos.
Ejemplo: luisfernandoaguasbucheli
1. Clase Guerrero:
Crea una clase llamada Guerrero que represente a un guerrero.
La clase debe tener los siguientes atributos:
• nombre (String)
• raza (String), que puede ser "Saiyajin", "Namekusein" o "Terrícola".
• nivelPoder (int)
• habilidad (String), que describe la habilidad principal del guerrero (por ejemplo,
"Kamehameha", "Cañón Especial", "Onda Explosiva").
2. Implementa dos constructores:
• Un constructor por defecto que inicialice los atributos con datos predefinidos.
• Un constructor con parámetros para inicializar los atributos con valores específicos.
3. Clase ColaGuerreros:
Crea una clase llamada ColaGuerreros que represente una cola de guerreros. Incluye los
métodos necesarios para manejar la cola y realizar las operaciones solicitadas. Predefine 5
objetos Guerrero en la estructura de la cola.
4. Implementa los siguientes métodos:
• R1: Método para encolar los 5 objetos de la cola. El primero se insertará invocando al
constructor por defecto y los 4 restantes con datos predefinidos. Despliega los
elementos en un elemento visual TextArea.
• R2: Método para calcular el nivel de poder total según la raza del guerrero. Si el guerrero
es Saiyajin, se multiplica su poder por 1.5; si es Namekusein, se multiplica por 1.2; y si
es Terrícola, el poder permanece igual. Este método debe desplegar todos los datos del
guerrero (nombre, raza, nivelPoder, habilidad) seguido por el nivel de poder total
calculado en un elemento visual JOptionPane.
• R3: Método para copiar en una nueva cola los objetos de Guerrero de una habilidad
específica. Esta nueva cola debe contener los mismos guerreros que la cola original, sin
eliminar los valores originales. Luego, imprime ambas colas en elementos visuales
TextArea.
