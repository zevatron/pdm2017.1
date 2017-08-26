//
//  SobreViewController.swift
//  Viagem
//
//  Created by X220 on 25/08/17.
//  Copyright © 2017 IFPB. All rights reserved.
//

import UIKit

class SobreViewController: UIViewController {
    
    var cadastro: Cadastro!
    @IBOutlet weak var lbQtd: UILabel!
    @IBOutlet weak var lbTotal: UILabel!
    
    override func viewWillAppear(_ animated: Bool) {
        lbQtd.text = String (self.cadastro.size())
        lbTotal.text = "R$ \(self.cadastro.total())"
        
    }
    

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
