function triggerUpload(inputId) {
    document.getElementById(inputId).click();
}

function uploadImage(imgId, modalImgId, inputId) {
    const fileInput = document.getElementById(inputId);
    const file = fileInput.files[0];

    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            // 업로드된 이미지가 카드와 모달 모두에 반영되도록
            document.getElementById(imgId).src = e.target.result;
            document.getElementById(modalImgId).src = e.target.result;
        }
        reader.readAsDataURL(file);
    }
}

function openProfileModal(modalId) {
    document.getElementById(modalId).style.display = 'block';
}

function closeProfileModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
}

// 팝업창 외부를 클릭하면 모달 닫기
window.onclick = function(event) {
    const modals = document.querySelectorAll('.modal');
    modals.forEach(modal => {
        if (event.target == modal) {
            closeProfileModal(modal.id);
        }
    });
}

