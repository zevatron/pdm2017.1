//
//  ViewController.swift
//  Viagem
//
//  Created by admin on 14/08/17.
//  Copyright © 2017 IFPB. All rights reserved.
//

import UIKit

class FormularioViewController: UIViewController {
    
    var cadastro:Cadastro!
    var viagem:Viagem!

    
    @IBOutlet weak var tfDestino: UITextField!
    @IBOutlet weak var lbQuantidade: UILabel!
    @IBOutlet weak var stQuantidade: UIStepper!
    @IBOutlet weak var swTemporada: UISwitch!
    @IBOutlet weak var tfOrcamento: UITextField!

    @IBAction func definirConvidados(_ sender: Any) {
        self.lbQuantidade.text = String(Int(self.stQuantidade.value))
    }


    @IBAction func salvar(_ sender: Any) {
        let destino = self.tfDestino.text
        let quantidade = Int(self.stQuantidade.value)
        let temporada = self.swTemporada.isOn
        let valor = Float(self.tfOrcamento.text!)
        
        self.viagem = Viagem(destino: destino!, convidados: quantidade, orcamento: valor!, altaTemporada: temporada)
        
        print("\(self.viagem)")
        self.cadastro.add(nova: self.viagem)
        
        self.navigationController?.popViewController(animated: true)
    }
   
  
}

