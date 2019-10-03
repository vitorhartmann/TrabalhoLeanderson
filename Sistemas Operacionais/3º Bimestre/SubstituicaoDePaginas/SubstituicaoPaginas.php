
<script>

// Equipe: 
/* 
	Vitor A. Hartmann
	Eliton Zimmermann
	Douglas F. Meier
	Maria Eduarda Pereira


*/

var Execucao = [ { pagina: 1, carga:200, ref: 370, br: 0, bm: 0 },
		{ pagina: 0, carga:157, ref: 359, br: 1, bm: 1},
		{ pagina: 3, carga:111, ref: 246, br: 1, bm: 0 }
	] 

function fifo() {

 for (var i=0; i<3; i=i+1) { 	
    return Execucao[i].pagina;
 } 
}

//Função p/ pegar a maior referenciação
function lru() {
 var pagina = null;
 var num = 0;
 
 for (var i=0; i<3; i=i+1) {
 	
    if(Execucao[i].ref > num){
    	pagina =  Execucao[i].pagina
        num = Execucao[i].ref
    }
 	   
 } 
 return pagina;
}

// Maior referenciação
function nru() {
 var pagina = null;
 var br = 0;
 var bm = 0;
 
 var pagina = Execucao.filter(Execucao => Execucao.br == 0 && Execucao.bm == 0);
 
 if(pagina.length == 0){
 	pagina = Execucao.filter(Execucao => Execucao.br == 0 && Execucao.bm == 1);
 }
 
 if(pagina.length == 0){
 	pagina = Execucao.filter(Execucao => Execucao.br == 1 && Execucao.bm == 0);
 }
 
 if(pagina.length == 0){
 	pagina = Execucao.filter(Execucao => Execucao.br == 1 && Execucao.bm == 1);
 }

 return pagina;
}

//First In First Out
document.write(fifo());

//Least Recently Used
document.write(lru());

//Not Recently Used
var Execucao = nru();
document.write(Execucao[0].pagina);

</script>
