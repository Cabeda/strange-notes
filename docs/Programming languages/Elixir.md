# Elixir

### Atoms

### Strings

### Lists

### Tuples & Keyword Lists

### Maps

### Enum

### Pattern Matching

### Pin Operator

### If and unless

### Case

### Cond

### With

### Sigils

### Functions and pipes

```elixir
defmodule Xpto do
	
	@doc """
Sum of two values
"""
	def sum(val1, vale) do
		val1 + val2
	end

	def sum2(val1, val2), do: val1 + val2

	def get_key(key, opts \\ []) do
		deleted = Keyword.get(ops, :deleted)

	end
	
end
```

Pipe is a first class citizen

```elixir
"Elixir rocks" |> String.upcase() |> String.split()
```

### Modules

```elixir
defmodule Example do
	import Example.Helper

	cast_to_integer("1")
end

defmodule Example.Helper do
	def cast_to_integer(val) when is_binary(val) do

	end

	def cast_to_integer(val) when is_numeric(val) do
		val
	end

	def cast_to_integer(_) do
		nil
	end
end
```

Structs

```elixir
defmodule MyApp.Vehicle do
	defstruct [:manufacturer, :model]
end

v = %Vehicle{manufacturer: "Audi", model:"A3"}

case v do
	%Vehicle{manufacturer: manufacturer} -> manufacturer
end
```

### Metaprogramming

### Behaviours

Comparável a interfaces. Permite definir um conjunto de funções devem ser implementadas 

```elixir
@callback init(state :: term) :: ok

defmodule Example.Compressor do
@behaviour Example.Compressor

def perform(payload, opts) do
end
end
# Returns errors as there isn't an init function
```

### Protocols

Forma de aplicar polimorfismo

```elixir
defmodule String.Chars, for Tuple do
	defstruct [:manufacture, ]
```

### Mix

Build tool para projetos de elixir

```bash
mix new example
cd example
mix deps.get
mix compile

mix test # test project
```

[Programming Languages](../Programming%20Languages.md)