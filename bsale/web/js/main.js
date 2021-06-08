
const url = 'http://localhost:8081'
const headers_http = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  };


const getProducts = () =>{
    fetch(url+'/api/products',{
        method:"GET",
        headers: headers_http
    }
    ).then((resp) =>{
        return resp.json();
    }).catch((error)=>{
        console.warn("Error",error)
    });
}

