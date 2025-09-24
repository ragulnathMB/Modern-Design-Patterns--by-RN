// Singleton Pattern – TypeScript Template
// Simple lazy-initialized singleton without external typings.

declare const console: any;

class Singleton {
  private static _instance: Singleton | null = null;
  private constructor() {}
  static getInstance(): Singleton {
    return this._instance ?? (this._instance = new Singleton());
  }
}

// Usage:
// const s = Singleton.getInstance();
