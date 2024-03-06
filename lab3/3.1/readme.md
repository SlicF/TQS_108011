## 3.1

### a)

whenFindAlexByName_thenReturnAlexEmployee(), whenInvalidEmployeeName_thenReturnNull(), whenFindEmployedByExistingId_thenReturnEmployee(), etc.

### b)

No teste B (B_EmployeeService_UnitTest), há um mock do employee Repository

### c)

Um Mock usa o framework "Mockito", trabalha fora do contexto da aplicação string e geralmente usa-se em teste unitários, enquanto que o MockBean tem o seu scope dentro da aplicação Spring, usa o framework de testes do Spring e é mais usado em teste de integração.

### d)

O ficheiro “application-integrationtest.properties” é usado para criar uma base de dados a ser usada nos testes, esta base de dados é criada sempre que sejam feitos testes que envolvam os repositórios dos "employees" (A_EmployeeRepositoryTest).

### e)

Na estratégia C controlador REST é testado de forma isolada. através de um MockBean, na estratégia D os beans da aplicação são encapsulados e disponibilizados para teste, na estratégia E todos os componentes do projeto são testados de forma direta sem mocks, a API é usada de forma direta.
