// select要素変更時に送信処理
const selects = document.querySelectorAll('select');
selects.forEach((select) => {
  select.addEventListener('change', function () {
    this.form.submit(); //  location.reload();では選択された値をサーバーに渡せない
  });
});

// クリックで選択(ハイライト)＆ roomId + category を維持して遷移

const areas = document.querySelectorAll('.area');



if (selectedRoomId !== 'ALL') {
  const selectedArea = document.querySelector(
    `.area[data-room="${selectedRoomId}"]`
  );
  if (selectedArea) {
    selectedArea.classList.add('selected');
  }
}

areas.forEach((area) => {
  area.addEventListener('click', () => {
    areas.forEach((a) => a.classList.remove('selected'));
    area.classList.add('selected');

    const roomId = area.dataset.room;
    // roomId + 現在のcategoryをURLに渡す
    window.location.href = `/team?roomId=${roomId}&category=${currentCategory}`;
  });
});
