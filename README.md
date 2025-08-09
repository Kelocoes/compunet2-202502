# Tareas Pendientes

## Repositorios por Crear
- **UserRepository**  
    Debe incluir información mockeada sencilla.
- **GamesRepository**  
    Debe incluir información mockeada sencilla.
- **CommentsRepository**  
    Debe incluir información mockeada sencilla.

## Servicios por Implementar
- **UserService**  
    Depende de: `UserRepository`  
    Crear el bean dentro del contexto Spring.
- **CommentsService**  
    Depende de: `CommentsRepository`  
    Crear el bean dentro del contexto Spring.
- **GameService**  
    Depende de: `CommentsService` y `UserRepository`  
    Crear el bean dentro del contexto Spring.