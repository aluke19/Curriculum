BancoSimulador (Java, consola)

Pequeña app de consola para simular operaciones bancarias básicas: registro, login, ingresos, retiradas y transferencias entre usuarios. Proyecto orientado a practicar POO y manejo de entradas por consola en Java.

✨ Funcionalidades

Registro de usuarios (nombre, contraseña y número de cuenta)

Inicio de sesión

Ingresar dinero

Retirar dinero

Transferencias entre usuarios (con validaciones)

Listado de movimientos por usuario



🗂️ Estructura del proyecto
src/
└── BancoSimulador/
    ├── Main.java                     # Menús y flujo de la app (consola)
    ├── models/
    │   └── Usuario.java              # Entidad usuario + saldo + movimientos
    └── servicios/
        └── Banco.java                # Gestión de usuarios y operaciones


Paquete raíz: BancoSimulador

🔧 Requisitos

Java 17+ (vale Java 11+, pero recomendado 17)

Terminal (o Visual Studio Code con “Extension Pack for Java”)

Comprueba tu versión:

java -version
javac -version

▶️ Cómo compilar y ejecutar

Importante: al tener package BancoSimulador;, debes ejecutar usando el nombre de paquete.

Opción A — Desde la carpeta padre del paquete

Ubícate en la carpeta que contiene BancoSimulador/ (por ejemplo .../JAVA/):

# Compilar
javac ./BancoSimulador/models/Usuario.java ./BancoSimulador/servicios/Banco.java ./BancoSimulador/Main.java

# Ejecutar
java BancoSimulador.Main

Opción B — Estando dentro de BancoSimulador/
# Compilar dejando los .class en la carpeta padre (classpath raíz)
javac -d .. ./models/Usuario.java ./servicios/Banco.java ./Main.java

# Ejecutar indicando el classpath
java -cp .. BancoSimulador.Main

Visual Studio Code (terminal integrada)

Abre la carpeta JAVA (la padre de BancoSimulador/).

Usa los comandos de la Opción A en la terminal integrada.

También puedes usar el botón ▶️ Run de Main.java (si tienes el Extension Pack for Java).

🕹️ Uso rápido (flujo recomendado)

Registrar dos usuarios
Menú → 1 → usuario1 / pass1 / ES001
Menú → 1 → usuario2 / pass2 / ES002

Ingresar a usuario1
Menú → 0 → Cantidad 100 → Usuario usuario1

Iniciar sesión como usuario1
Menú → 2 → usuario1 / pass1

Ver saldo
Menú usuario → 1 → debería mostrar 100.00€

Transferir a usuario2
Menú usuario → 3 → destino usuario2 → cantidad 50
Resultado: usuario1 queda con 50.00€, usuario2 recibe 50.00€

Ver movimientos
Menú usuario → 2 → verás Ingreso/Retiro/Ingreso según corresponda

Nota: Si introduces decimales, usa punto (20.5) a menos que hayas añadido helpers para admitir coma.



🧠 Diseño (resumen)

Usuario: guarda nombreUsuario, password, numeroCuenta, saldo y List<String> movimientos.
Registra automáticamente los movimientos en ingresar/retirar.

Banco: gestiona usuarios en memoria, registrarUsuario, buscarUsuario, login y transferir.
transferir valida nulos, cantidad, evita auto-transferencias y usa retirar/ingresar (sin duplicar movimientos).

Main: menús de consola con Scanner y control de flujo.



✅ Validaciones clave

No se puede ingresar ni retirar cantidades ≤ 0.

No puedes transferirte a ti mismo.

No se transfiere si el saldo es insuficiente.

En registro se evita duplicado por nombre de usuario.



🧪 Casos de prueba manual (rápidos)

Transferir más de lo que tienes → debe fallar con mensaje.

Registrar usuario existente → debe avisar y no duplicar.

Transferir a usuario que no existe → debe avisar.

Ingresar cantidad negativa → debe avisar.



🛣️ Posibles mejoras (roadmap corto)

Añadir fecha/hora y concepto a los movimientos.

Helpers para leer números y aceptar coma , sin romper (Scanner robusto).

Persistencia simple a fichero/JSON (y, si quieres subir nivel, a SQL).

Encriptar password (hash) para mejorar seguridad en el porfolio.

Tests unitarios sencillos con JUnit (básicos para Banco y Usuario).




👤 Autor

Álvaro Luque Moreno