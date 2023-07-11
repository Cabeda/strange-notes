# Git

Git switch - switch branches or xreatet

Git restore - restore a file to the version in a given commit or branch

## Useful commands

```shell
git -am "Message commit" # Shortcut to
git commit --ammend ""
git fetch origin
git clean -df # Clean repo
git switch - # Go to last branch
git stash save <name>
git stash pop list
git stash apply <index>
git log --graph --oneline --decorate

git bisect start
git bisect bad
git bisect good <commit id>

## Squash
git rebase master --interactive
git commit --squash <branch>
git rebase master -i --autosquash

```

## Git commit messages

[Source](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)

See how a minor change to your commit message style can make you a better programmer.

Format: `<type>(<scope>): <subject>`

`<scope>` is optional

## Reset to origin branch

```shell

git fetch origin
git reset --hard origin/<branch>
```

## Example

```shell
feat: add hat wobble
^--^  ^------------^
|     |
|     +-> Summary in present tense.
|
+-------> Type: chore, docs, feat, fix, refactor, style, or test.
```

More Examples:

- `feat`: (new feature for the user, not a new feature for build script)
- `fix`: (bug fix for the user, not a fix to a build script)
- `docs`: (changes to the documentation)
- `style`: (formatting, missing semi colons, etc; no production code change)
- `refactor`: (refactoring production code, eg. renaming a variable)
- `test`: (adding missing tests, refactoring tests; no production code change)
- `chore`: (updating grunt tasks etc; no production code change)

## Stacked pull requests

Way to stack pull requests on top of each other. In this way you are sure that your changes are applied with the latest changes that have yet to be deploy to main.

Github impleentation: https://github.com/ejoffe/spr
