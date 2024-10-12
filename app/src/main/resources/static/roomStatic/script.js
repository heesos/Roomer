document.addEventListener('DOMContentLoaded', () => {
    const roomList = document.getElementById('room-list');

    fetch('http://localhost:8081/roomsList')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(rooms => {
            rooms.forEach(room => {
                const roomTile = document.createElement('div');
                roomTile.className = 'room-tile';

                const imgSrc = room.pictureURL ? room.pictureURL : 'https://via.placeholder.com/300'; // Placeholder image
                roomTile.innerHTML = `
                    <img src="${imgSrc}" alt="${room.description}">
                    <h2>${room.description}</h2>
                    <p>Landlord: ${room.landLord}</p>
                    <p>Price: $${room.price}</p>
                `;

                roomList.appendChild(roomTile);
            });
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
            roomList.innerHTML = '<p>Error fetching room listings.</p>';
        });
});
