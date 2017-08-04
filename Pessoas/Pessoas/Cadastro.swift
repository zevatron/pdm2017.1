//
//  Cadastro.swift
//  Pessoas
//
//  Created by admin on 04/08/17.
//  Copyright © 2017 IFPB. All rights reserved.
//

import Foundation

class Cadastro {
    var lista:Array<Pessoa>!

    init() {
        self.lista = Array<Pessoa>()
    }
    
    func addPessoa(pessoa:Pessoa){
        self.lista.append(pessoa)
    }
    
    func size() -> Int{
        return self.lista.count
    }
}
