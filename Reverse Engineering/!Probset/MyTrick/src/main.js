// Import Tauri API
const { invoke } = window.__TAURI__.tauri;

document.addEventListener('DOMContentLoaded', () => {
    const nameInput = document.getElementById('name');
    const passwordInput = document.getElementById('password');
    const repasswordInput = document.getElementById('repassword');
    const processBtn = document.getElementById('process-btn');
    const output = document.getElementById('output');

    processBtn.addEventListener('click', async () => {
        const name = nameInput.value;
        const password = passwordInput.value;
        const repassword = repasswordInput.value;

        // Validate inputs
        if (!name || !password || !repassword) {
            output.innerHTML = '<span class="error">All fields are required.</span>';
            return;
        }

        try {
            output.innerHTML = 'Processing...';
            
            const response = await invoke('process_information', {
                name: name,
                password: password,
                repassword: repassword
            });
            
            if (response.success) {
                output.innerHTML = `<span class="success">${response.message}</span>`;
            } else {
                output.innerHTML = `<span class="error">${response.message}</span>`;
            }
        } catch (error) {
            output.innerHTML = `<span class="error">Error: ${error}</span>`;
        }
    });

    // Allow CLI-like usage with Enter key
    document.addEventListener('keydown', (e) => {
        if (e.key === 'Enter' && document.activeElement === repasswordInput) {
            processBtn.click();
        }
    });
});
