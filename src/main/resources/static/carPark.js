'use strict';

const backEndPath = "http://localhost:8080";

const carMake = document.querySelector('#carMake');
const carModel = document.querySelector('#carModel');
const arrivalDate = document.querySelector('#arrivalDate');
const leavingDate = document.querySelector('#departureDate');
const output = document.querySelector('#output');
const viewAllBookings = document.querySelector('#viewAllBookings');
const submitUpdateButton = document.querySelector('#submitUpdate');
const bookingRemovedTag = document.querySelector('#bookingRemovedTag'); 

const printToScreen = (information) => {
  

    const newColumn = document.createElement("div");
    newColumn.className = "col";

    viewAllBookings.appendChild(newColumn);
 
    const newBooking = document.createElement("div");
    newBooking.className = "card"
    newColumn.appendChild(newBooking);
 
    const bookingBody = document.createElement("div");
    bookingBody.className = "card-body";
    newBooking.appendChild(bookingBody);
 
    const bookingMake = document.createElement("h5");
    bookingMake.className = "card-title";
    bookingMake.innerText = information.make;
    bookingBody.appendChild(bookingMake);
 
    const bookingText = document.createElement("p");
    bookingText.className = "card-text";
    bookingText.innerHTML = "Model: " + information.model;
    bookingText.innerHTML += "<br>";
    bookingText.innerHTML += "Arrival Date: " + information.arrivalDate;
    bookingText.innerHTML += "<br>";
    bookingText.innerHTML += "Departure Date: " + information.leavingDate;
    bookingBody.appendChild(bookingText);
 
    const bookingFooter= document.createElement("div");
    bookingFooter.className = "card-footer"
    newBooking.appendChild(bookingFooter);
 
    const deleteBookingButton = document.createElement("button");
    deleteBookingButton.className = "btn btn=primary";
    deleteBookingButton.innerText = "Delete";
    deleteBookingButton.addEventListener(`click`, () => deleteBooking(information.id));
    bookingFooter.appendChild(deleteBookingButton);
 
    const editBookingButton = document.createElement("button");
    editBookingButton.className = "btn btn-primary";
    editBookingButton.innerText = "Edit Booking";
    editBookingButton.addEventListener(`click`, () => showUpdateForm(information.id));
   
    bookingFooter.appendChild(editBookingButton);
 
    return newColumn;

}

const deleteBooking = (id) => {
    axios.delete("http://localhost:8080/remove/" + id)
    .then((resp) => {
        console.log(resp);
        bookingRemovedTag.innerHTML = "The booking has been removed";
        setTimeout(() => {
            bookingRemovedTag.innerHTML = "";
            location.reload();
        }, 2000);
    }).catch((err) => console.error(err));
    
    }

const showBookingForm = () => {
    document.getElementById('createBookingForm').style.display = 'block';
   
}

const showUpdateForm = (id) => {
    document.getElementById('updateBookingForm').style.display = 'block';
    console.log("hi", id);
    submitUpdateButton.addEventListener(`click`, () => updateBooking(id));
}

const updateBooking = (id) => {
    console.log(id);
    const updatedCarMake = document.querySelector('#updatedCarMake');
    const updatedCarModel = document.querySelector('#updatedCarModel');
    const updatedArrivalDate = document.querySelector('#updatedArrivalDate');
    const updatedLeavingDate = document.querySelector('#updatedDepartureDate');

    const updatedCarMakeValue = updatedCarMake.value;
    const updatedCarModelValue = updatedCarModel.value;
    const updatedArrivalDateValue = updatedArrivalDate.value;
    const updatedLeavingDateValue = updatedLeavingDate.value;

    let updateObj = {
        make: updatedCarMakeValue,
        model: updatedCarModelValue,
        arrivalDate: updatedArrivalDateValue,
        leavingDate: updatedLeavingDateValue
    };

    axios.put(`http://localhost:8080/update/${id}`, updateObj, {
    "headers":{
        "Access-Control-Allow-Origin":"*"
    }
    }).then((resp) => {
        console.log(resp);
        document.getElementById('updateBookingForm').style.display = 'none';
        output.innerHTML = "Update Successful!";
        setTimeout(() => {
            output.innerHTML = "";
            location.reload();
        }, 2000);
    }).catch((err) => console.error(err));
}

const createUser = () => {
    
    const carMakeValue = carMake.value;
    const carModelValue = carModel.value;
    const arrivalDateValue = arrivalDate.value.toString();
    console.log(typeof(arrivalDateValue));
    const leavingDateValue = leavingDate.value.toString();

    let obj = {
        make: carMakeValue,
        model: carModelValue,
        arrivalDate: arrivalDateValue,
        leavingDate: leavingDateValue
    };

    console.log(obj);

    axios.post("http://localhost:8080/create", obj, {
        "headers":{
            "Access-Control-Allow-Origin":"*"
        }
    }).then((resp) => {
        console.log(resp);
        document.getElementById('createBookingForm').style.display = 'none';
        output.innerHTML = "Booking Successfully created!";
        setTimeout(() => {
            output.innerHTML = "";
            location.reload();
        },3000);
    }).catch((err) => console.error(err));

    

}

const getBookings = () => {
    axios.get("http://localhost:8080/getAll")
    .then((response) => {
        console.log(response.data);

        for (let data of response.data){
            
            printToScreen(data)
            
            for (let i in data) {
                console.log(data[i]);
            }
        }
        
    }).catch((err) => {
        console.error(err);
    });
}
