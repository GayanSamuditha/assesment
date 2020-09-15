import { Observable } from 'rxjs';


export class ApiMain {

    private protocol = 'http';
    private hostName = 'localhost';
    private port = '8080';
    private contextPath = '';

    private mainApiUrl: string;

    constructor() {}

    public getMainApiUrl(): string {

        this.mainApiUrl = this.protocol + '://' + this.hostName + ':' + this.port + '/' + this.contextPath + '/';

        return this.mainApiUrl;
    }

    public getApiUrl(url: string): string {

        const fullUrl: string = this.getMainApiUrl() + url;

        return fullUrl;
    }
  }
