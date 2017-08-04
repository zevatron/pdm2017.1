//
//  Pessoa.swift
//  Pessoas
//
//  Created by admin on 04/08/17.
//  Copyright © 2017 IFPB. All rights reserved.
//

import Foundation

class Pessoa: NSObject{
    var nome: String!
    var idade: Int!
    
    init(nome:String, idade:Int) {
        self.nome=nome
        self.idade=idade
    }
    
    override var description: String{
        return "\(nome) - \(idade)"
    }
    
    func maiorIdade() -> Bool {
        return self.idade >= 18
    }
    
}
