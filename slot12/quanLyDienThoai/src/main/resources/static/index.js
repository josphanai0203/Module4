function getSmartphone(smartphone) {
    return `<tr id="${smartphone.id}"><td >${smartphone.producer}</td><td >${smartphone.model}</td><td >${smartphone.price}</td>` +
        `<td><button  class="deleteSmartphone btn btn-primary"  onclick="deleteSmartphone(${smartphone.id})">Delete</button></td></tr>`;

}

function addNewSmartPhone() {
    //lay du lieu
    let producer = $('#producer').val();
    let model = $('#model').val();
    let price = $('#price').val();
    let newSmartphone = {
        producer: producer,
        model: model,
        price: price
    };
    // goi ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newSmartphone),
        //tên API
        url: "/smartphones",
        //xử lý khi thành công
        success: successHandler

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "/smartphones",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            let content = '    <tr>\n' +
                '        <td>Producer</td>\n' +
                '        <td>Model</td>\n' +
                '        <td>Price</td>\n' +
                '        <td>Delete</td>\n' +
                '    </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getSmartphone(data[i]);
            }
            document.getElementById('smartphoneList').innerHTML = content;
        }
    });
}

function deleteSmartphone(id) {
    $.ajax({
        type: "DELETE",
        //tên API
        url: `/smartphones/${id}`,
        //xử lý khi thành công
        success: function (data) {
            $(`#${id}`).remove();
        }

    });
}
$(document).ready(function () {
    successHandler();

})