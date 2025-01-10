# task-list-refactoring
[![TaskListRefactoring](https://github.com/SarthakMakhija/task-list-refactoring/actions/workflows/build.yml/badge.svg)](https://github.com/SarthakMakhija/task-list-refactoring/actions/workflows/build.yml)

### Idea

This repository aims to refactor a slightly modified version of [TaskList](https://kata-log.rocks/task-list-kata). 
The refactored code addresses numerous code smells present in the original implementation, including:

- [Broken Encapsulation](https://refactoring.guru/smells/inappropriate-intimacy)
- [Data classes](https://refactoring.guru/smells/data-class)
- [Divergent change](https://refactoring.guru/smells/divergent-change)
- [Feature envy](https://refactoring.guru/smells/feature-envy)
- [Long method](https://refactoring.guru/smells/long-method)
- [Switch statements](https://refactoring.guru/smells/switch-statements)
- [Primitive obsession](https://refactoring.guru/smells/primitive-obsession)

The original code is available [here](https://github.com/SarthakMakhija/task-list-refactoring/tree/original).

### Refactoring techniques used

The following refactoring techniques were used:

- [Extract method](https://refactoring.guru/extract-method)
- [Replace temp with query](https://refactoring.guru/replace-temp-with-query)
- [Move method](https://refactoring.guru/move-method)
- [Introduce Local Extension](https://refactoring.guru/introduce-local-extension)
- [Extract Interface](https://refactoring.guru/extract-interface)
- [Rename Method](https://refactoring.guru/rename-method)
- [Introduce assertion](https://refactoring.guru/introduce-assertion)

### What is not covered

- This repository does not implement any feature mentioned in the original [TaskList](https://github.com/codurance/task-list/) repository.
- This repository does not implement solitary unit-tests. All the unit-tests are sociable.