export type ListaProduto = Produto[]

export type Produto = {
  id: number
  nome: string
  descricao: string
  preco: number
  listaCampos: Campo[]
}
  
export type Campo = {
  id?: number
  nome: string
  obrigatorio?: boolean
}

export type Resposta = {
  campo: Campo,
  valor: string
}

export type Adesao = {
  idProdutoModel: number,
  listaRespostas: Resposta[]
}

export type Credencias = {
  login: string,
  password: string
}