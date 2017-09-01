//
//  Cadastro.swift
//  Viagem
//
//  Created by admin on 14/08/17.
//  Copyright © 2017 IFPB. All rights reserved.
//

import Foundation

class Cadastro: NSObject{
    
    var lista:Array<Viagem>!
    
    override init() {
        self.lista = Array<Viagem>()
    }
    
    func add(nova:Viagem){
        self.lista.append(nova)
    }
    
    func get(index:Int)->Viagem{
        return self.lista[index]
    }
    
    func size() -> Int{
        return self.lista.count
    }
    
    func total() -> Float{
        var acumulador:Float = 0
        for v in self.lista{
            acumulador += v.orcamento
        }
        return acumulador
    }
    func del(index:Int){
        self.lista.remove(at: index)
    }
    
    func move(origem:Int, destino:Int){
        let aux = self.lista[origem]
        self.lista[origem] = self.lista[destino]
        self.lista[destino] = aux
    }
    
}
