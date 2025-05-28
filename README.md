# API de Gestão de Cursos e Matrículas

## Entidades principais

### 1. Curso

- **Atributos**: `id`, `nome`, `descricao`, `cargaHoraria`
- **Relacionamentos**:
  - Um curso pode ter muitos módulos (1:N).
  - Um curso pode ter muitos alunos matriculados (N:M).

### 2. Módulo

- **Atributos**: `id`, `titulo`, `descricao`, `curso_id`
- **Relacionamentos**:
  - Cada módulo pertence a um único curso (N:1).
  
### 3. Aluno

- **Atributos**: `id`, `nome`, `email`, `senha`
- **Relacionamentos**:
  - Um aluno pode estar matriculado em vários cursos (N:M).

## Relacionamentos obrigatórios

- Um para Muitos (1:N): Um Curso possui muitos Módulos.
- Muitos para Muitos (N:M): Um Aluno pode se matricular em vários Cursos, e um Curso pode ter vários Alunos.
  
## Regras de autenticação (Spring Security)

**Endpoints públicos**:

- POST /usuario – Criar novo usuário (aluno).
- POST /auth – Autenticação e retorno do token JWT.
  
**Endpoints privados (requerem token JWT)**:

- Cadastro, listagem e alteração de cursos e módulos.
- Matrícula de alunos em cursos.
- Listagem dos cursos em que um aluno está matriculado.
