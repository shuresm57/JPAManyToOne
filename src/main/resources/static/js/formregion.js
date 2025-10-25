console.log("jeg er i formregion");

document.addEventListener("DOMContentLoaded", createFormEventListener);

function createFormEventListener() {
    const formRegion = document.getElementById("formRegion");
    formRegion.addEventListener("submit", handleFormSubmit);
}

async function handleFormSubmit(event) {
    event.preventDefault();
    const form = event.currentTarget;
    const url = form.action;

    try {
        const formData = new FormData(form);
        console.log("FormData object:", formData);

        const responseData = await postFormDataAsJson(url, formData);
        console.log("Response data:", responseData);

    } catch (error) {
        alert(error.message);
        console.error("Error submitting form:", error);
    }
}

async function postFormDataAsJson(url, formData) {
    const plainFormData = Object.fromEntries(formData.entries());
    return postObjectAsJson(url, plainFormData, "POST");
}

async function postObjectAsJson(url, object, httpVerbum) {
    const objectAsJsonString = JSON.stringify(object);
    console.log("JSON payload:", objectAsJsonString);

    const fetchOptions = {
        method: httpVerbum,
        headers: {
            "Content-Type": "application/json",
        },
        body: objectAsJsonString,
    };

    const response = await fetch(url, fetchOptions);

    if (!response.ok) {
        const errorMessage = await response.text();
        throw new Error(errorMessage);
    }

    return response.json();
}
