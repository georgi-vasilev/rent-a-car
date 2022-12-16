export class Car {
    constructor(id, manufacturer, model, category, imageUrl, pricePerDay, hasClimateControl, numberOfSeats, transmissionType, isAvailable) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.category = category;
        this.imageUrl = imageUrl;
        this.pricePerDay = pricePerDay;
        this.hasClimateControl = hasClimateControl;
        this.numberOfSeats = numberOfSeats;
        this.transmissionType = transmissionType;
        this.isAvailable = isAvailable;
    }
    id?: number;
    manufacturer: string;
    model: string;
    category: number;
    imageUrl: string;
    pricePerDay: number;
    hasClimateControl: boolean;
    numberOfSeats: number;
    transmissionType: number;
    isAvailable?: boolean;
    dealer?: Profile;
}

export interface Profile {
    username: string;
    phoneNumber: string;
}