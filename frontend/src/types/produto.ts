export type ListaProduto = Produto[]

export type Produto = {
  id: number
  nome: string
  descricao: string
  preco: number
  listaCampos: Campo[]
}
  
export type Campo = {
  id: number
  nome: string
  obrigatorio: boolean
}