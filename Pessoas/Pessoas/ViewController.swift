//
//  ViewController.swift
//  Pessoas
//
//  Created by admin on 04/08/17.
//  Copyright © 2017 IFPB. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tfIdade: UITextField!
    var cadastro = Cadastro()
    
    
    @IBAction func btCadastrar(_ sender: Any) {
        
    }
    
    
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

