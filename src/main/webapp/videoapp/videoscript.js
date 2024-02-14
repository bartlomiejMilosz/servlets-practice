document.addEventListener('DOMContentLoaded', (event) => {
    const params = new URLSearchParams(window.location.search);
    const videos = params.getAll('video');
    const container = document.querySelector('.videos-container'); // Znajduje kontener
    
    videos.forEach(videoId => {
        const iframe = document.createElement('iframe');
        iframe.src = `https://www.youtube.com/embed/${videoId}`;
        iframe.width = '560';
        iframe.height = '315';
        iframe.allowFullscreen = true;
        container.appendChild(iframe);
    });
});
