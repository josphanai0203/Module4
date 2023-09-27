function searchByTitle() {
    let valueSearch = $('#searchInput').val();
    let url = "http://localhost:8080/api/v1/blog/search"
    $.ajax({
        url: url,
        data: {
            name: valueSearch
        },
        type: "get",
        dataType: "json",
        success: function (res){
            console.log(res)
            let html = "";
            for (var i =0;i<res.length;i++) {
                html +=
                    "<div>"+"<h3 class='mb-3'>"+"<a href='/blog?id="+res[i].blogId+ "'>"+ res[i].title+"</a></h3>"+
                    " <p class='w-100 truncate-lines'>"+"<a href='/blog?id="+res[i].blogId+"'>"+ res[i].content+"</a>"+"</p>"
                    +
                    "</div>"
            }
            $("#content").html(html);
        },
        error:function (e){
            console.log(e);
        }
    });


}
function loadMore(){
    let nextPage = $('#currentPage').val();
    nextPage = 2 + parseInt(nextPage);
    let url = "http://localhost:8080/api/v1/blog/list"
    $.ajax({
        url: url,
        data: {
            page: nextPage,
        },
        type: "get",
        dataType: "json",
        success: function (res){
            let html = "";
            for (var i =0;i<res.content.length;i++) {
                html +=
                    "<div>"+"<h3 class='mb-3'>"+"<a href='/blog?id="+res.content[i].blogId+ "'>"+ res.content[i].title+"</a></h3>"+
                    " <p class='w-100 truncate-lines'>"+"<a href='/blog?id="+res.content[i].blogId+"'>"+ res.content[i].content+"</a>"+"</p>"
                    +
                    "</div>"
            }
            $('#currentPage').val(res.number);
            $("#content").append(html);
        },
        error:function (e){
            console.log(e);
        }
    });
}
