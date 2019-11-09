package br.com.dunoans.duck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_novo_produto.*
import kotlin.math.roundToLong

class NovoProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_produto)
        setTitle("Novo Produto")

        adicionar_produto.setOnClickListener {
            var p = Produto()
            p.nome = nome_produto.text.toString()
            p.quantidade = qtd_produto.text.toString().toInt()
            p.valor = valor_produto.text.toString().toDouble()
            p.descricao = desc_produto.text.toString()
            p.foto = foto_produto.text.toString()

            taskAdicionar(p)
        }
    }

    private fun taskAdicionar(produto: Produto) {
        // Thread para salvar a discilpina
        Thread {
            ProdutoService.save(produto)
            runOnUiThread {
                // após cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }

}
