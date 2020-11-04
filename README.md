# simios-api


Instruções de execução da API:

PASSO 1 - Acessar o link abaixo

https://simios-api-production.herokuapp.com/swagger-ui.html

Na api simios colar o json abaixo no campo value e clicar em Try It Out 

{
  "dna": [
   "CTGAGA", "CTGAGC","TATTGT","AGAGGG", "CCCCTA", "TCACTG"
  ]
}

Para executar a API stats basta clicar no Try It Out 

Caso queira executar as apis em algum programa API client , como o postman por exemplo basta importar o Curl , segue os links abaixo


curl -X POST "https://simios-api-production.herokuapp.com/simian"


curl -X GET "https://simios-api-production.herokuapp.com/stats"


Para mais detalhes sobre a API acesse os links abaixo

https://simios-api-production.herokuapp.com/

https://ingridmazoni.github.io/simios-api/


  
    
    
    
